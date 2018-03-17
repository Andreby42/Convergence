package com.convergence.support.lock.redission;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class DistributedLockFactoryBean implements FactoryBean<DistributedLockTemplate> {
    private Logger logger = LoggerFactory.getLogger(DistributedLockFactoryBean.class);

    private LockInstanceMode mode;

    private DistributedLockTemplate distributedLockTemplate;

    private RedissonClient redisson;

    @PostConstruct
    public void init() {
        String ip = "127.0.0.1";
        String port = "6379";
        Config config = new Config();
        config.useSingleServer().setAddress(ip + ":" + port);
        redisson = Redisson.create(config);
        System.out.println("成功连接 Redis Server" + "\t" + "连接" + ip + ":" + port + "服务器");
    }

    @PreDestroy
    public void destroy() {
        logger.debug("销毁分布式锁模板");
        redisson.shutdown();
    }

    @Override
    public DistributedLockTemplate getObject() throws Exception {
        switch (mode) {
            case SINGLE:
                distributedLockTemplate = new SingleDistributedLockTemplate(redisson);
                break;
        }
        return distributedLockTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return DistributedLockTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setMode(String mode) {
        if (mode == null || mode.length() <= 0 || mode.equals("")) {
            throw new IllegalArgumentException("未找到 dlm.redisson.mode 配置项");
        }
        this.mode = LockInstanceMode.parse(mode);
        if (this.mode == null) {
            throw new IllegalArgumentException("不支持的分布式锁模式");
        }
    }

    private enum LockInstanceMode {
        SINGLE;
        public static LockInstanceMode parse(String name) {
            for (LockInstanceMode modeIns : LockInstanceMode.values()) {
                if (modeIns.name().equals(name.toUpperCase())) {
                    return modeIns;
                }
            }
            return null;
        }
    }
}
