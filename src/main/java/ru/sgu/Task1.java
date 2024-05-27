package org.example;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Task7 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/company";
        String username = "rrrr";
        String password = "rrrr";

        String q1 = "SELECT employeeName, age FROM employeesAge WHERE age > 20";

        String q2 = "SELECT " +
                "    dl.departmentName as departmentName, " +
                "    Avg(ds.salary) as averageSalary " +
                "FROM departmentSalary as ds " +
                "JOIN departmentLocation as dl " +
                "ON ds.departmentId = dl.id " +
                "GROUP BY departmentName";

        String q3 = "SELECT " +
                "    ea.employeeName as employeeName, " +
                "    dl.location as departmentLocation, " +
                "    dl.departmentName as departmentName " +
                "FROM departmentEmployee as de " +
                "JOIN employeesAge as ea " +
                "ON de.employeeId = ea.id " +
                "JOIN departmentLocation as dl " +
                "ON de.departmentId = dl.id";

        Class.forName("org.postgresql.Driver");

        DbWrapper dbWrapper = new DbWrapper(jdbcUrl, username, password);
        dbWrapper.connect();

        List<List<String>> res1 = dbWrapper.executeQuery(q1, Arrays.asList("employeeName", "age"));
        System.out.println("Список сотрудников старше 20 лет:");
        printRows(res1);
        System.out.println();

        List<List<String>> res2 = dbWrapper.executeQuery(q2, Arrays.asList("departmentName", "averageSalary"));
        System.out.println("Средняя ЗП по отделам:");
        printRows(res2);
        System.out.println();

        List<List<String>> res3 = dbWrapper.executeQuery(q3, Arrays.asList("employeeName", "departmentLocation", "departmentName"));
        System.out.println("Список имен сотрдуников и их департаментов:");
        printRows(res3);
        System.out.println();
    }

    static void printRows(List<List<String>> rows) {
        for (List<String> row : rows) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.print("\n");
        }
    }
}
