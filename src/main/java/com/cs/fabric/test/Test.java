package com.cs.fabric.test;

import java.awt.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.SSLException;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;

import com.cs.fabric.client.InvokeChainCode;
import com.google.protobuf.InvalidProtocolBufferException;

public class Test {
	public static void main(String[] args) throws InterruptedException, ExecutionException, InvalidArgumentException,
			ProposalException, TimeoutException, CryptoException, NoSuchAlgorithmException, NoSuchProviderException,
			InvalidKeySpecException, TransactionException, IOException {

		int taskName;
		int workNum;
		TestUtil testUtil = new TestUtil();
		if (args.length > 0) {
			taskName = Integer.parseInt(args[0]);
			workNum = Integer.parseInt(args[1]);
			
		} else {

			taskName = 30;
			workNum = 10;
		}
		
		testUtil.test(taskName,workNum);
		

		// String a = "a" + 1 + 4;
		// System.out.println(a);

		// System.out.println("fffff" + InvokeChainCode.time);

		// final String[] arguments = new String[] { "a", "b","1" };
		// InvokeChainCode invokeChainCode = new InvokeChainCode(arguments);
		// invokeChainCode.invoke();
	}
}
