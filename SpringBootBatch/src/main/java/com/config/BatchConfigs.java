package com.config;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.mapper.EmpMapper;
import com.model.Student;

@Configuration
@EnableBatchProcessing
public class BatchConfigs {
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
	
//	@Bean
//	public FlatFileItemReader<Student> getStudentReader(){
//		
//		
//		FlatFileItemReaderBuilder<Student> builder = new FlatFileItemReaderBuilder<Student>();
//		
//		Resource resource = new FileSystemResource(new File("c:\\test\\students.csv"));
//		builder.resource(resource);
//		builder.name("csvReader");
//		builder.fieldSetMapper(new EmpMapper());
//		builder.delimited().names(new String[]{"name","age","salary"});
//		return builder.build();
//	}
	
	@Bean
	public FlatFileItemReader<Student> getStudentReader(){
		
		
		FlatFileItemReader<Student> builder = new FlatFileItemReader<Student>();
		Resource resource = new FileSystemResource(new File("c:\\test\\students.csv"));
		builder.setResource(resource);
		builder.setName("csvReader");
		
		DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<Student>();
		lineMapper.setFieldSetMapper(new EmpMapper());
		lineMapper.setLineTokenizer(new DelimitedLineTokenizer(DelimitedLineTokenizer.DELIMITER_COMMA));
		builder.setLineMapper(lineMapper);
		
		
		return builder;
	}
	
	/*@Bean
	public FlatFileItemWriter<Student> getStudentWriter(){
		FlatFileItemWriterBuilder<Student> builder = new FlatFileItemWriterBuilder<Student>();
		Resource resource = new FileSystemResource(new File("c:\\test\\studentsConverted.csv"));
		builder.resource(resource);
		builder.name("csvWriter");
		builder.lineAggregator(new PassThroughLineAggregator<Student>());
		return builder.build();
		
	}*/
	
	@Bean
	public Job createJob() {
		return jobBuilderFactory.get("csvReaderToWriter").incrementer(new RunIdIncrementer()).flow(createStep()).build().build();
	}
	
	@Bean
	public Step createStep() {
		return stepBuilderFactory.get("createStep").<Student,Student>chunk(10000).reader(getStudentReader()).writer(getStudentWriter()).build();
	}
	
	@Bean
	public FlatFileItemWriter<Student> getStudentWriter(){
		
		FlatFileItemWriter<Student> builder = new FlatFileItemWriter<Student>();
		Resource resource = new FileSystemResource(new File("c:\\test\\studentsConverted.csv"));
		builder.setResource(resource);
		builder.setName("csvWriter");
		builder.setLineAggregator(new PassThroughLineAggregator<Student>());
		return builder;
		
	}
	
	@Bean
    public Step step1(FlatFileItemWriter<Student> writer) {
		StepBuilder builder = stepBuilderFactory.get("step1");
		SimpleStepBuilder<Student,Student> stepBuilder =builder.chunk(10);
		stepBuilder.reader(getStudentReader());
		stepBuilder.writer(getStudentWriter());
		return stepBuilder.build();
		
    }
	
	/*@Bean
    public FlatFileItemReader<Student> reader() {
        return new FlatFileItemReaderBuilder<Student>()
            .name("personItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"firstName", "lastName"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                setTargetType(Student.class);
            }})
            .build();
    }*/

}
