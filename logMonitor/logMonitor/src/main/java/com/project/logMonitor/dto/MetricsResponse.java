package com.project.logMonitor.dto;

public class MetricsResponse {
    private long totalLogs;
    private long errorLogs;
    private long warnLogs;
    private long infoLogs;
    private long totalAlerts;

    public long getTotalLogs() {
        return totalLogs;
    }

    public void setTotalLogs(long totalLogs) {
        this.totalLogs = totalLogs;
    }

    public long getErrorLogs() {
        return errorLogs;
    }

    public void setErrorLogs(long errorLogs) {
        this.errorLogs = errorLogs;
    }

    public long getWarnLogs() {
        return warnLogs;
    }

    public void setWarnLogs(long warnLogs) {
        this.warnLogs = warnLogs;
    }

    public long getInfoLogs() {
        return infoLogs;
    }

    public void setInfoLogs(long infoLogs) {
        this.infoLogs = infoLogs;
    }

    public long getTotalAlerts() {
        return totalAlerts;
    }

    public void setTotalAlerts(long totalAlerts) {
        this.totalAlerts = totalAlerts;
    }
}
