package Lec6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpAndMgr {
	public void EmpUnderManager(Map<String, String> employeeToMgr) {
		HashMap<String, List<String>> directReportees = new HashMap<>();
		// ArrayList<String> keys = new ArrayList<>(employeeToMgr.keySet());

		for (Map.Entry<String, String> entry : employeeToMgr.entrySet()) {
			String emp = entry.getKey();
			String mgr = entry.getValue();
			if (emp.equals(mgr))
				continue;

			List<String> directEmployeesForMgr = directReportees.getOrDefault(mgr, new ArrayList<>());
			directEmployeesForMgr.add(emp);
			directReportees.put(mgr, directEmployeesForMgr);
		}

		HashMap<String, Integer> numberOfEmployees = new HashMap<>();
		// write the code here
	}
}
