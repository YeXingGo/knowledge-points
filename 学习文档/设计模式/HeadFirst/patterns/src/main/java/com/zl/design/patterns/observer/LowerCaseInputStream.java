package com.zl.design.patterns.observer;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @描述： TODO  继承 了 FilterInputStream 类，  可以对
 * InputStream类中的 read() 做一些装饰
 * @作者: Light
 * @时间: 2019/8/24  15:43
 * @版本：
 */
public class LowerCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int read = in.read();
        return (read == -1 ? read : Character.toLowerCase((char)read));
    }

}
