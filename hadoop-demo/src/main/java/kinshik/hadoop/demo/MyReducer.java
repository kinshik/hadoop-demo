package kinshik.hadoop.demo;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, LongWritable, NullWritable, Text> {

	@Override
	protected void reduce(Text arg0, Iterable<LongWritable> arg1, Reducer<Text, LongWritable, NullWritable, Text>.Context arg2) throws IOException, InterruptedException {
		long count = 0;
		Iterator<LongWritable> iterator = arg1.iterator();
		while (iterator.hasNext()) {
			count += iterator.next().get();
		}
		arg2.write(null, new Text(arg0.toString() + "\t" + count));
	}
}
