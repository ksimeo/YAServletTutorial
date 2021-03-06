package com.ksimeo.ya.tutorial.helpers;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 * @author Ksimeo. Created on 01.11.2016 at 20:45 for "Movies(withServlets)" project.
 * @version 1.0
 * @since 1.0
 */
public class SecurityHelper {

    public static String String2Hash(String str) throws NoSuchProviderException, NoSuchAlgorithmException {

        Security.addProvider(new BouncyCastleProvider());

        MessageDigest mda = MessageDigest.getInstance("SHA-512", "BC");

        return new String(Base64.encode(mda.digest(str.getBytes())));
    }
}
