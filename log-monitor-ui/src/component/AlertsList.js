// import { useEffect, useState } from "react";
// import api from "../services/api";

// function AlertsList() {
//   const [alerts, setAlerts] = useState([]);

//   useEffect(() => {
//     api.get("/alerts")
//       .then(response => {
//         console.log("Alerts response:", response.data); // good practice
//         setAlerts(response.data);
//       })
//       .catch(error => {
//         console.error("Error fetching alerts", error);
//       });
//   }, []);

//   return (
//     <div>
//       <h2>Alerts</h2>

//       <table border="1" width="100%">
//         <thead>
//           <tr>
//             <th>ID</th>
//             <th>Type</th>
//             <th>Message</th>
//             <th>Triggered At</th>
//           </tr>
//         </thead>

//         <tbody>
//           {alerts.map(alert => (
//             <tr key={alert.id}>
//               <td>{alert.id}</td>
//               <td>{alert.type}</td>
//               <td>{alert.message}</td>
//               <td>{alert.createdAt}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// }

// export default AlertsList;


import { useEffect, useState } from "react";
import api from "../services/api";

function AlertsList() {
  const [alerts, setAlerts] = useState([]);
  const [typeFilter, setTypeFilter] = useState("");
  const [searchText, setSearchText] = useState("");

  useEffect(() => {
    api.get("/alerts")
      .then(response => {
        setAlerts(response.data);
      })
      .catch(error => {
        console.error("Error fetching alerts", error);
      });
  }, []);

  const formatDate = (dateString) => {
    return new Date(dateString).toLocaleString();
  };

  const filteredAlerts = alerts.filter(alert => {
    return (
      (typeFilter === "" || alert.type === typeFilter) &&
      (searchText === "" ||
        alert.message.toLowerCase().includes(searchText.toLowerCase()))
    );
  });

  return (
    <div>
      {/* Filters */}
      <div style={{ marginBottom: "10px" }}>
        <select
          value={typeFilter}
          onChange={(e) => setTypeFilter(e.target.value)}
        >
          <option value="">All Types</option>
          <option value="ERROR_THRESHOLD">ERROR_THRESHOLD</option>
          {/* add more alert types here later */}
        </select>

        <input
          type="text"
          placeholder="Search alert message"
          value={searchText}
          style={{ marginLeft: "10px" }}
          onChange={(e) => setSearchText(e.target.value)}
        />
      </div>

      <h2>Alerts</h2>

      <table border="1" width="100%" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Message</th>
            <th>Triggered At</th>
          </tr>
        </thead>

        <tbody>
          {filteredAlerts.length === 0 ? (
            <tr>
              <td colSpan="4" align="center">No alerts found</td>
            </tr>
          ) : (
            filteredAlerts.map(alert => (
              <tr key={alert.id}>
                <td>{alert.id}</td>
                <td>{alert.type}</td>
                <td>{alert.message}</td>
                <td>{formatDate(alert.createdAt)}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default AlertsList;
