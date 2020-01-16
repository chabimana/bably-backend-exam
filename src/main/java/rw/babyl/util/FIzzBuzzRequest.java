package rw.babyl.util;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: chabiman
 * @FileName: FIzzBuzzRequest.java
 * @Date: Jan 16, 2020
 * @Package: rw.babyl.util
 * @ProjectName: babyl-backend-exam
 *
 */
public class FIzzBuzzRequest {

	@NotNull(message = "Please provide a number to start the list")
	@Min(value = 0, message = "Negative numbers not allowed")
	private int startAt;

	@NotNull(message = "Please provide a number at which the process will stop")
	private int stopAt;

	/**
	 * @return the startAt
	 */
	public int getStartAt() {
		return this.startAt;
	}

	/**
	 * @param startAt the startAt to set
	 */
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	/**
	 * @return the stopAt
	 */
	public int getStopAt() {
		return this.stopAt;
	}

	/**
	 * @param stopAt the stopAt to set
	 */
	public void setStopAt(int stopAt) {
		this.stopAt = stopAt;
	}

	/*
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FIzzBuzzRequest [startAt=" + this.startAt + ", stopAt=" + this.stopAt + "]";
	}

}
