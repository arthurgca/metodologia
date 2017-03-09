package org.metodologia;

import java.math.BigDecimal;

public class Task {

	private BigDecimal cpuReq;
	private BigDecimal memoryReq;

	public Task(BigDecimal cpuString, BigDecimal memString) {
		this.cpuReq = cpuString;
		this.memoryReq = memString;
	}

	public BigDecimal getMemoryReq() {
		return memoryReq;
	}

	public BigDecimal getCpuReq() {
		return cpuReq;
	}

}
