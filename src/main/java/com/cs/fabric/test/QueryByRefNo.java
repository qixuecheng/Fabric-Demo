package com.cs.fabric.test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;

import com.cs.fabric.client.InvokeChainCode;

public class QueryByRefNo {

	public static void main(String[] args) throws CryptoException, InvalidArgumentException, NoSuchAlgorithmException,
			NoSuchProviderException, InvalidKeySpecException, TransactionException, IOException {

		final String[] arguments = new String[] { "a"};

		InvokeChainCode invokeChainCode = new InvokeChainCode(arguments);

		try {
			invokeChainCode.queryByRefNo();
		} catch (InvalidArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProposalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
