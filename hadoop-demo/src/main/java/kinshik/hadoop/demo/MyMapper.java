package kinshik.hadoop.demo;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import biz.source_code.base64Coder.Base64Coder;

public class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
		// context.write(new Text(value.toString()), new LongWritable(1));

		for (String string : value.toString().split("\\s+")) {
			if (!string.trim().isEmpty()) {
				string = Base64Coder.encodeString(string.trim());
				string = Base64Coder.decodeString(string.trim());
				context.write(new Text(string.trim()), new LongWritable(1));
			}
		}
	}
}
