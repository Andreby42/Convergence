package com.convergence.common;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 
 * @doc: 谷歌的布隆过滤器
 * @author byW
 * @date
 */
public class BloomFilterTest {
    static int sizeOfNumberSet = Integer.MAX_VALUE >> 4;
    static BloomFilter<String> filter =
            BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), sizeOfNumberSet);
    static BloomFilter<Integer> intFilter =
            BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet);
    //三参数 第三个参数为允许的错误率
    static BloomFilter<Integer> intFilters =
            BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet,0.00001);
    //四参数 第四个参数为哈希算法 默认算法为BloomFilterStrategies.MURMUR128_MITZ_64
    static BloomFilter<Integer> intFilterss =
            BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet,0.00001);
    public static void testBloomFilter() {
        boolean flag1 = filter.put("123");
        boolean flag2 = filter.put("123");
        System.out.println(flag1);
        System.out.println(flag2);

        boolean flag3 = intFilter.put(123);
        boolean flag4 = intFilter.put(123);
        //使用mightContain 来判断是否存在
        boolean flag5 = intFilter.mightContain(123);
        // intFilter.readFrom(in, funnel)
        System.out.println(flag3);
        System.out.println(flag4);
        System.out.println(flag5);

    }

    public static void main(String[] args) {
        testBloomFilter();
    }
}
