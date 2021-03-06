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

package com.skplanet.jose.jwe;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

import com.skplanet.jose.Jose;
import com.skplanet.jose.JoseBuilders;
import com.skplanet.jose.JoseHeader;
import com.skplanet.jose.commons.codec.binary.Base64;
import com.skplanet.jose.jwa.alg.JweAlgResult;
import com.skplanet.jose.jwa.enc.ContentEncryptKeyGenerator;
import com.skplanet.jose.jwa.enc.JweEncResult;
import com.skplanet.jose.util.ByteUtils;
import org.junit.Before;
import org.junit.Test;

import com.skplanet.jose.jwa.Jwa;
import com.skplanet.jose.jwa.alg.RSA15Algorithm;
import com.skplanet.jose.jwa.enc.AesEncryptionWithHmacSha;
import com.skplanet.jose.jwa.crypto.CryptoUtils;

public class Jwe_RSA1_5_A128CBC_HS256Test {
	String n = "sXchDaQebHnPiGvyDOAT4saGEUetSyo9MKLOoWFsueri23bOdgWp4Dy1Wl"
			+"UzewbgBHod5pcM9H95GQRV3JDXboIRROSBigeC5yjU1hGzHHyXss8UDpre"
			+"cbAYxknTcQkhslANGRUZmdTOQ5qTRsLAt6BTYuyvVRdhS8exSZEy_c4gs_"
			+"7svlJJQ4H9_NxsiIoLwAEk7-Q3UXERGYw_75IDrGA84-lA_-Ct4eTlXHBI"
			+"Y2EaV7t7LjJaynVJCpkv4LKjTTAumiGUIuQhrNhZLuF_RJLqHpM2kgWFLU"
			+"7-VTdL1VbC2tejvcI2BlMkEpk1BzBZI0KQB0GaDWFLN-aEAw3vRw";

	String e = "AQAB";

	String d = "VFCWOqXr8nvZNyaaJLXdnNPXZKRaWCjkU5Q2egQQpTBMwhprMzWzpR8Sxq"
			+"1OPThh_J6MUD8Z35wky9b8eEO0pwNS8xlh1lOFRRBoNqDIKVOku0aZb-ry"
			+"nq8cxjDTLZQ6Fz7jSjR1Klop-YKaUHc9GsEofQqYruPhzSA-QgajZGPbE_"
			+"0ZaVDJHfyd7UUBUKunFMScbflYAAOYJqVIVwaYR5zWEEceUjNnTNo_CVSj"
			+"-VvXLO5VZfCUAVLgW4dpf1SrtZjSt34YLsRarSb127reG_DUwg9Ch-Kyvj"
			+"T1SkHgUWRVGcyly7uvVGRSDwsXypdrNinPA4jlhoNdizK2zF2CWQ";

	BigInteger bn;
	BigInteger be;
	BigInteger bd;

	RSAPublicKey publicKey;
	RSAPrivateKey privateKey;
	byte[] pubKey;
	byte[] priKey;

	@Before
	public void setUp() throws Exception {
		bn = new BigInteger(1, Base64.decodeBase64(n));
		be = new BigInteger(1, Base64.decodeBase64(e));
		bd = new BigInteger(1, Base64.decodeBase64(d));

		publicKey = CryptoUtils.generateRsaPublicKey(bn, be);
		privateKey = CryptoUtils.generateRsaPrivateKey(bn, bd);
		pubKey = publicKey.getEncoded();
		priKey = privateKey.getEncoded();
	}

	@Test
	public void TestRSAKeyEncryptionAndVerify() throws Exception {
		byte[] cek = { (byte) 4, (byte) 211, (byte) 31, (byte) 197, (byte) 84, (byte) 157, (byte) 252,
				(byte) 254, (byte) 11, (byte) 100, (byte) 157, (byte) 250, (byte) 63, (byte) 170, (byte) 106,
				(byte) 206, (byte) 107, (byte) 124, (byte) 212, (byte) 45, (byte) 111, (byte) 107, (byte) 9,
				(byte) 219, (byte) 200, (byte) 177, (byte) 0, (byte) 240, (byte) 143, (byte) 156, (byte) 44, (byte) 207 };

		ContentEncryptKeyGenerator cekGenerator = new ContentEncryptKeyGenerator(32);
		cekGenerator.setUserEncryptionKey(cek);

		RSA15Algorithm joseAlgorithm = new RSA15Algorithm();
		JweAlgResult jweAlgResult = joseAlgorithm.encryption(pubKey, cekGenerator);
		byte[] actual = joseAlgorithm.decryption(priKey, jweAlgResult.getEncryptedCek());

		assertThat(ByteUtils.equals(actual, cek), is(true));
	}
	
	@Test
	public void TestJweSerirializeAndDeserialize() throws Exception {
		byte[] cek = { (byte) 4, (byte) 211, (byte) 31, (byte) 197, (byte) 84, (byte) 157, (byte) 252,
				(byte) 254, (byte) 11, (byte) 100, (byte) 157, (byte) 250, (byte) 63, (byte) 170, (byte) 106,
				(byte) 206, (byte) 107, (byte) 124, (byte) 212, (byte) 45, (byte) 111, (byte) 107, (byte) 9,
				(byte) 219, (byte) 200, (byte) 177, (byte) 0, (byte) 240, (byte) 143, (byte) 156, (byte) 44, (byte) 207 };

		byte[] iv = { (byte) 3, (byte) 22, (byte) 60, (byte) 12, (byte) 43, (byte) 67, (byte) 104, (byte) 105,
				(byte) 108, (byte) 108, (byte) 105, (byte) 99, (byte) 111, (byte) 116, (byte) 104, (byte) 101 };

		String payload = "Live long and prosper.";

		String serializedSource = new Jose().configuration(JoseBuilders.JsonEncryptionCompactSerializationBuilder()
				.header(new JoseHeader(Jwa.RSA1_5, Jwa.A128CBC_HS256))
				.payload(new String(payload))
				.key(publicKey)
		).serialization();

		String actual = new Jose().configuration(
				JoseBuilders.compactDeserializationBuilder()
				.serializedSource(serializedSource)
				.key(privateKey)
		).deserialization();

		assertThat(actual, is(payload));
	}
}
