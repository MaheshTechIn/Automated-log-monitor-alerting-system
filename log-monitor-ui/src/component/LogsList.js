// import { useEffect, useState } from "react";
// import api from "../services/api";

// function LogsList() {
//   const [logs, setLogs] = useState([]);
//   const [levelFilter, setLevelFilter] = useState("");
//   const [searchText, setSearchText] = useState("");


//   useEffect(() => {
//     api.get("/logs")
//       .then(response => {
//         console.log(response.data);      
//         setLogs(response.data.content);
//       })
//       .catch(error => {
//         console.error("Error fetching logs", error);
//       });
//   }, []);

//     const formatDate = (dateString) => {
//     return new Date(dateString).toLocaleString();
//   };

//   return (
    
//     <div>

//           <div style={{ marginBottom: "10px" }}>
//             <select onChange={(e) => setLevelFilter(e.target.value)}>
//               <option value="">All Levels</option>
//               <option value="ERROR">ERROR</option>
//               <option value="WARN">WARN</option>
//               <option value="INFO">INFO</option>
//             </select>

//       <input
//         type="text"
//         placeholder="Search message"
//         style={{ marginLeft: "10px" }}
//         onChange={(e) => setSearchText(e.target.value)}
//       />
//     </div>

//       <h2>Logs</h2>
//       <ul>
//         {logs.filter(log => {
//           return (
//             (levelFilter === "" || log.level === levelFilter) &&
//             (searchText === "" ||
//               log.message.toLowerCase().includes(searchText.toLowerCase()))
//           );
//         }).map(log => (
//           <li key={log.id}>
//             [{log.level}] {log.message}
//           </li>
//         ))}

//       </ul>
//     </div>
//   );
// }

// export default LogsList;


import { useEffect, useState } from "react";
import api from "../services/api";

function LogsList() {
  const [logs, setLogs] = useState([]);
  const [levelFilter, setLevelFilter] = useState("");
  const [searchText, setSearchText] = useState("");

  useEffect(() => {
    api.get("/logs")
      .then(response => {
        setLogs(response.data.content);
      })
      .catch(error => {
        console.error("Error fetching logs", error);
      });
  }, []);

  const formatDate = (dateString) => {
    return new Date(dateString).toLocaleString();
  };

  const filteredLogs = logs.filter(log => {
    return (
      (levelFilter === "" || log.level === levelFilter) &&
      (searchText === "" ||
        log.message.toLowerCase().includes(searchText.toLowerCase()))
    );
  });

  return (
    <div>
      {/* Filters */}
      <div style={{ marginBottom: "10px" }}>
        <select
          value={levelFilter}
          onChange={(e) => setLevelFilter(e.target.value)}
        >
          <option value="">All Levels</option>
          <option value="ERROR">ERROR</option>
          <option value="WARN">WARN</option>
          <option value="INFO">INFO</option>
        </select>

        <input
          type="text"
          placeholder="Search message"
          value={searchText}
          style={{ marginLeft: "10px" }}
          onChange={(e) => setSearchText(e.target.value)}
        />
      </div>

      <h2>Logs</h2>

      <table border="1" width="100%" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Level</th>
            <th>Message</th>
            <th>Timestamp</th>
          </tr>
        </thead>

        <tbody>
          {filteredLogs.length === 0 ? (
            <tr>
              <td colSpan="4" align="center">No logs found</td>
            </tr>
          ) : (
            filteredLogs.map(log => (
              <tr key={log.id}>
                <td>{log.id}</td>
                <td>{log.level}</td>
                <td>{log.message}</td>
                <td>{formatDate(log.timestamp)}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default LogsList;
