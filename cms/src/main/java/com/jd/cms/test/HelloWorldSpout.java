package com.jd.cms.test;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

public class HelloWorldSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private int referenceNumber;
    private static final int MAX_NUMBER = 10;

    public HelloWorldSpout() {
        final Random random = new Random();
        referenceNumber = random.nextInt(MAX_NUMBER);
    }

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }

    public void nextTuple() {
        Utils.sleep(100);
        final Random random = new Random();
        int instanceNumber = random.nextInt(MAX_NUMBER);
        if(instanceNumber == referenceNumber){
//            System.out.println("");
            collector.emit(new Values("Hello World"));
        }else{
            collector.emit(new Values("Another Message"));
        }

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("sentence"));

    }
}
