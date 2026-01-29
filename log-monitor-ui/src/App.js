import { useEffect, useState } from "react";
import api from "./services/api";
import LogsList from "./component/LogsList";
import AlertsList from "./component/AlertsList";

function App() {
  const [metrics, setMetrics] = useState({});

  useEffect(() => {
    api.get("/metrics")
      .then(res => setMetrics(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Automated Log Monitoring Dashboard</h1>

      {/* Metrics */}
      <div style={{ display: "flex", gap: "20px", marginBottom: "20px" }}>
        <div>Total Logs: {metrics.totalLogs}</div>
        <div>Error Logs: {metrics.errorLogs}</div>
        <div>Warn Logs: {metrics.warnLogs}</div>
        <div>Info Logs: {metrics.infoLogs}</div>
        <div>Alerts: {metrics.totalAlerts}</div>
      </div>

      <div style={{ display: "flex", gap: "20px" }}>
        <div style={{ width: "50%" }}>
          <LogsList />
        </div>
        <div style={{ width: "50%" }}>
          <AlertsList />
        </div>
      </div>
    </div>
  );
}

export default App;