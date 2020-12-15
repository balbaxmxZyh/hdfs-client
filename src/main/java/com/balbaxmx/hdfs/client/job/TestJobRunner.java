package com.balbaxmx.hdfs.client.job;

import com.balbaxmx.hdfs.client.mapper.TestMapper;
import com.balbaxmx.hdfs.client.reduce.TestReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @Author: zhangyh
 * @ClassName: TestJobRunner
 * @Date: 2020/8/12 10:03
 * @Operation:
 * @Description: 创建一个job，设置map和reduce
 *
 *  还可以指定该作业要处理的数据所在的路径
 *  还可以指定该作业输出的结果放到哪个路径
 */
public class TestJobRunner {

    public static void main(String[] args) throws Exception {

        Job job = Job.getInstance(new Configuration());

        //指定map类
        job.setMapperClass(TestMapper.class);
        //指定map key输出类型
        job.setMapOutputKeyClass(Text.class);
        //指定map value输出类型
        job.setMapOutputValueClass(IntWritable.class);

        /*
        map的输入类型不能控制，是框架传递过来的
        默认情况下框架传给我们的mapper的输入数据中,key是要处理的文本中一行的起始偏移量,
        因为我们的框架是读一行就调用一次我们的偏移量
         */

        //指定reduce类
        job.setReducerClass(TestReduce.class);
        //reduce key结果输出类型
        job.setOutputKeyClass(Text.class);
        //reduce value结果输出类型
        job.setOutputValueClass(Text.class);

        /*
           指定数据源（文件源）和输出源（文件目标）
         */

        //指定原始数据存放在哪里
        //参数1：里面是对哪个参数进行指定
        //参数2：文件在哪个路径下,这个路径下的所有文件都会去读的(可以多个)
        //FileInputFormat.setInputPaths(job, new Path[]{new Path("input/data1")});
        FileInputFormat.setInputPaths(job, new Path("input/data1"));
        //指定结果数据存放在哪里
        //参数1：里面是对哪个参数进行指定
        //参数2：文件在哪个路径下,结果保存在该路径下,MR的输出结果默认为part-r-00000
        FileOutputFormat.setOutputPath(job, new Path("input/result"));

        //提交
        int isok = job.waitForCompletion(true) ? 0 : -1;
        System.exit(isok);

        /*
        MR的输出结果默认为part-r-00000
        1、可以替换part
        2、自定义路径

         */

        //1、part替换score
        job.setOutputFormatClass(MyOut.class);
        MyOut.setOutputName(job, "score");
        job.waitForCompletion(true);

        //2、自定义结果文件
        job.setOutputFormatClass(MyFileOutputFormat.class);
        MyFileOutputFormat.setCompressOutput(job,true);
        job.waitForCompletion(true);

    }

    private static class MyOut extends TextOutputFormat {

        protected static void setOutputName(JobContext job, String name) {
            job.getConfiguration().set(BASE_OUTPUT_NAME, name);
        }
    }
}
