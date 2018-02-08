package com.cs.fabric.test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;

import com.cs.fabric.client.InvokeChainCode;
class TestUtil {
	
	void test(int taskSize,int workerNum) throws InterruptedException, ExecutionException, TimeoutException {
		System.out.println("----程序开始运行----");
		
		Date date1 = new Date();

		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个有返回值的任务
		ArrayList<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " ",workerNum);
			// 执行任务并获取Future对象
			Future f = pool.submit(c);
			
			list.add(f);
		}
		// 关闭线程池
		pool.shutdown();

		// 获取所有并发任务的运行结果
		for (Future f : list) {
			// 从Future对象上获取任务的返回值，并输出到控制台
			//System.out.println(">>>" + f.get());
			
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}

	class MyCallable implements Callable<Object> {
		private String taskNum;
		private int workNum;

		MyCallable(String taskNum,int workNum) {
			this.taskNum = taskNum;
			this.workNum = workNum;
		}

		public Object call() throws CryptoException, InvalidArgumentException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, TransactionException, IOException, ProposalException, InterruptedException, ExecutionException, TimeoutException {
				
			System.out.println(">>>" + taskNum + "任务启动");
			
			Date dateTmp1 = new Date();
			InvokeChainCode invokeChainCode = new InvokeChainCode();
			for(int i = 0; i < workNum; i++)
			{
				String A = "a"  + i + taskNum.trim();
				String B = "b" + i + taskNum.trim();
				final String[] arguments = new String[] { A, B, "1" };
				invokeChainCode.SetArgs(arguments); 
				invokeChainCode.invoke();
			}
			
			Date dateTmp2 = new Date();
			long time = dateTmp2.getTime() - dateTmp1.getTime();
			System.out.println(">>>" + taskNum + "任务终止");
			System.out.println(time);
			return taskNum + "任务返回运行结果,当前任务时间【"  + "毫秒】";
		}
	}

}
