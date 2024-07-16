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
		for (String emp : employeeToMgr.keySet()) { // O(n) * O(1)
			int reportees = calculateNumber(emp, directReportees, numberOfEmployees);
			System.out.println(emp + " " + reportees);
		}
	}

	private int calculateNumber(String emp, HashMap<String, List<String>> directReportees,
			HashMap<String, Integer> numberOfEmployees) {
		// time complexity of calculate O(1)
		if (numberOfEmployees.containsKey(emp)) { // O(1)
			return numberOfEmployees.get(emp);
		}
		int total = 0;
		if (directReportees.containsKey(emp)) {
			List<String> jrs = directReportees.get(emp);
			for (String jr : jrs) { // on avg O(1)
				int jrCount = calculateNumber(jr, directReportees, numberOfEmployees) + 1;
				total += jrCount;
			}
		}
		numberOfEmployees.put(emp, total);
		return total;
	}
}
