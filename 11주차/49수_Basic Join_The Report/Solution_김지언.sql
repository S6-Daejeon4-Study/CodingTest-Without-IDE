select if(grade < 8, NULL, name), grade, marks
from students s join grades g
on s.marks between g.min_mark and g.max_mark
order by grade desc, name, marks