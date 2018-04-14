package com.pratik.common.utils.closable;

import java.io.Closeable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;

public class IoUtil {
	public static void close(Closeable c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(MessageProducer c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(MessageConsumer c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(Session c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(Connection c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(Context c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(ResultSet c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(PreparedStatement c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
	public static void close(java.sql.Connection c) {
		try {
			c.close();
		} catch (Exception ignore) {
		}
	}
}

