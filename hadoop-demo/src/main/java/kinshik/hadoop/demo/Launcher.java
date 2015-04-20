package kinshik.hadoop.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Launcher {

	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			throw new IllegalArgumentException("Required 2 arguments: IN and OUT!");
		}

		Path hdfsFile = new Path(args[0]);
		Path hdfsFile2 = new Path(args[1]);

		Configuration conf = new Configuration();

		// conf.set("textinputformat.record.delimiter","]");

		Job job = Job.getInstance(conf);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);

		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(job, hdfsFile);
		FileOutputFormat.setOutputPath(job, hdfsFile2);

		job.setJarByClass(Launcher.class);

		job.setJobName("Word count");

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}