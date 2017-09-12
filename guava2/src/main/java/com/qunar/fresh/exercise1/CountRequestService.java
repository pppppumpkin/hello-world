package com.qunar.fresh.exercise1;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.sun.media.jfxmedia.logging.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-5-23.
 */
public class CountRequestService {
    // 请求次数分类统计
    private static int postRequestNum;
    private static int getRequestNum;
    private static int requestNum;
    // http接口访问次数统计
    private static Multiset<String> httpInterfaceSet = HashMultiset.create();
    // 按url类型存储
    private static Multimap<String, String> urlMap = HashMultimap.create();
    // private static Map<String, List<String>> urlMap = Maps.newHashMap();
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CountRequestService.class);

    /**
     * Get data from accessLog file and save result to result file
     * 
     * @param accessLogPath
     * @param resultPath
     * @throws IOException
     */
    public static void processFile(String accessLogPath, final String resultPath) throws IOException {
        Files.readLines(new File(accessLogPath), Charsets.UTF_8, new LineProcessor() {
            public boolean processLine(String line) throws IOException {
                // http接口访问次数统计
                List<String> reqInfo = Splitter.on(" ").splitToList(line);
                String reqType = reqInfo.get(0);
                String reqUrl = Splitter.on('?').splitToList(reqInfo.get(1)).get(0); // 没有？的就得到一个长度为1的List，也是第0个位置
                httpInterfaceSet.add(reqUrl);
                // url分类统计
                List<String> urlSegment = Splitter.on('/').splitToList(reqUrl);
                String urlType = urlSegment.get(1);
                urlMap.put(urlType, reqUrl);
                // 请求次数分类统计
                requestNum++;
                if (Objects.equal(reqType, "POST")) {
                    postRequestNum++;
                } else if (Objects.equal(reqType, "GET")) {
                    getRequestNum++;
                }
                return true;
            }

            public List<String> getResult() {
                try {
                    saveResult(resultPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }

    /**
     * Write result to file
     * 
     * @param resultPath
     * @throws IOException
     */
    public static void saveResult(String resultPath) throws IOException {
        File resultFile = new File(resultPath);
        Closer closer = Closer.create();
        try {
            BufferedWriter writer = closer.register(new BufferedWriter(new FileWriter(resultFile)));
            writer.write("Total request : " + requestNum + "\n");
            writer.write("Post request : " + postRequestNum + "\n");
            writer.write("Get request : " + getRequestNum + "\n");
            writer.write("\n");
            writer.write("---- Http interface request top 10 ----\n");
            writer.write(Joiner.on("\n").join(getRequestTopX(10)));
            writer.write("\n");
            writer.write("\n-------- URIs group by urlType --------\n");
            writer.write(Joiner.on("\n").join(getUrlGroupByUrlType()));
            // writer.write(urlMap.toString());
        } finally {
            closer.close();
        }
    }

    /**
     * Get list of http request top x
     * 
     * @param x
     * @return topList
     */
    public static List<String> getRequestTopX(int x) {
        List<String> topList = Lists.newArrayListWithCapacity(x);
        ImmutableMultiset<String> highestCountSet = Multisets.copyHighestCountFirst(httpInterfaceSet);
        // topList = Ordering.natural().greatestOf(highestCountSet.elementSet(), 10);
        int count = 0;
        for (Multiset.Entry<String> entry : highestCountSet.entrySet()) {
            topList.add(Joiner.on(":").join(entry.getElement(), entry.getCount()));
            count++;
            if (count == x) {
                break;
            }
        }
        return topList;
    }

    public static List<String> getUrlGroupByUrlType() {
        List<String> urlList = Lists.newArrayList();
        for (String urlType : urlMap.keySet()) {
            urlList.add(Joiner.on(" :\n").join(urlType, Joiner.on("\n").join(urlMap.get(urlType))));
        }
        return urlList;
    }
}
