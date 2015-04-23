package kinshik.hadoop.demo;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import biz.source_code.base64Coder.Base64Coder;

public class MyMapperJson extends Mapper<LongWritable, Text, Text, LongWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
		context.write(new Text("" + value.toString().length()), new LongWritable(1));
	}
}
