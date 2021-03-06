/*
 * Copyright (c) 2015 SK PLANET. ALL Rights Reserved.
 *
 * Syrup Pay Jose Library
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.skplanet.jose.jwa.alg;

import com.skplanet.jose.exception.EncryptionException;
import com.skplanet.jose.exception.IllegalEncryptionKey;
import com.skplanet.jose.jwa.JweAlgorithm;
import com.skplanet.jose.jwa.crypto.Algorithm;
import com.skplanet.jose.jwa.crypto.CryptoUtils;
import com.skplanet.jose.jwa.crypto.Transformation;
import com.skplanet.jose.jwa.enc.ContentEncryptKeyGenerator;

/**
 * Created by 박병찬 on 2015-07-29.
 */
public class AesKeyWrapAlgorithm implements JweAlgorithm {
	private int fixedkeyLength;

	//0.3.2 이전 버전에서는 key length를 체크하지 않았음.
	public AesKeyWrapAlgorithm() {
		this.fixedkeyLength = 0;
	}

	public AesKeyWrapAlgorithm(int keyLength) {
		this.fixedkeyLength = keyLength;
	}

	private void isValidKey(byte[] key) {
		if (fixedkeyLength != 0 && key.length != fixedkeyLength) {
			throw new IllegalEncryptionKey("JWE key must be "+fixedkeyLength+" bytes. yours key "+key.length+" bytes.");
		}
	}

	public JweAlgResult encryption(byte[] key, ContentEncryptKeyGenerator cekGenerator) {
		isValidKey(key);

		Transformation transformation = new Transformation(Algorithm.AES);
		byte[] cek = cekGenerator.generateRandomKey();
		try {
			return new JweAlgResult(cek, CryptoUtils.KeyWrap(transformation, key, cek));
		} catch (Exception e) {
			throw new EncryptionException(transformation.getValue()+"KeyWrapException", e);
		}
	}

	public byte[] decryption(byte[] key, byte[] cek) {
		isValidKey(key);

		Transformation transformation = new Transformation(Algorithm.AES);
		try {
			return CryptoUtils.keyUnwrap(transformation, key, cek);
		} catch (Exception e) {
			throw new EncryptionException(transformation.getValue()+"KeyUnwrapException", e);
		}
	}
}
