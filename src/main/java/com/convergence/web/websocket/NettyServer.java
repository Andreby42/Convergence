package com.convergence.web.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.convergence.support.util.CommonUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class NettyServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public static final int WEB_SOCKET_PORT = 9527;


    public void run(int port) throws Exception {
        // 一个接收总线
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 一个处理总线
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast("http-codec", new HttpServerCodec()); // Http 消息编码解码
                            pipeline.addLast("aggregator", new HttpObjectAggregator(65536)); // Http
                                                                                             // 消息组装
                            pipeline.addLast("http-chunked", new ChunkedWriteHandler()); // WebSocket
                                                                                         // 通信支持
                            // SimpleChannelInboundHandler inboud 和 outboud 是一對
                            // pipeline.addFirst(arg0)
                            pipeline.addLast("handler", new CustomWebSocketServerHandler()); // 服務端handler
                            // 可以繼續往后addLast
                        }
                        // ChannelOption 設置隊列 參數設置 allows to configure a {@link ChannelConfig}
                    }).option(ChannelOption.SO_TIMEOUT, 3000).option(ChannelOption.AUTO_READ, true)
                    .option(ChannelOption.TCP_NODELAY, true).option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(592048))
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000);


            Channel channel = b.bind(port).sync().channel();
            logger.info("WebSoketServer Started ************");
            channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("something wrong with server" + CommonUtil.getStackTraceInfo(e));
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
