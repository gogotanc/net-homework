package cn.gogotanc.work.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncoderTest {

    @Test
    public void encoderByMD5() throws Exception {
        String result = Encoder.encoderByMD5("buyer");
        assertEquals("794AAD24CBD58461011ED9094B7FA212", result);
    }

    @Test
    public void byteArray2Hex() throws Exception {
        String result = Encoder.byteArray2Hex(new byte[]{55, 54});
        assertEquals("3736", result);
    }

}