/*
Enter your query here.
*/

select s.name, g.grade, s.marks from students s left join grades g on s.marks <= g.max_mark and s.marks >= g.min_mark where s.marks >= 70 order by g.grade desc, s.name, s.marks;
select null, g.grade, s.marks from students s left join grades g on s.marks <= g.max_mark and s.marks >= g.min_mark where s.marks < 70 order by g.grade desc, s.name, s.marks;