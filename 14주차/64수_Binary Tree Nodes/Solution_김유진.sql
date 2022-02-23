/*
Enter your query here.
*/

-- select N, if(P is null,"Root", "??") from BST;

-- select 
-- N, 
-- if(P is null,
--    "Root", 
--    if(
--        (select count(P) from BST 
--        where P is not null and P not in (select N from BST))
--        = 0,
--        "Leaf",
--        "Inner"
--    )
--   ) 
-- from BST;

-- select 
-- N, 
-- if(P is null,
--    "Root", 
--    if(
--        ( P not in (select N from BST))
--        ,
--        "Leaf",
--        "Inner"
--    )
--   ) 
-- from BST;


select 
N, 
if(P is null,
   "Root", 
   if(N not in (select P from BST where P is not null),
      "Leaf",
      "Inner"
     )
  ) 
from BST
order by N;

-- select N,P from bst;


-- (select N from BST 
--        where N is not null and not exists (select P  from BST where P is not null))

-- select 14 not exists (select N from BST);
-- select 2 where 0 not in (select N from BST);

-- select N from BST 
--        where N not in (select P from BST where P is not null);

-- select N from BST 
--        where N not in ();
