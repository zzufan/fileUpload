package com.zzxtit.fileUpload.editor;

import java.util.List;

public class EditImgResMsg {

	private int errno;
	
	private List<String> data;

	/**
	 * @return the errno
	 */
	public int getErrno() {
		return errno;
	}

	/**
	 * @param errno the errno to set
	 */
	public void setErrno(int errno) {
		this.errno = errno;
	}

	/**
	 * @return the data
	 */
	public List<String> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}
}
