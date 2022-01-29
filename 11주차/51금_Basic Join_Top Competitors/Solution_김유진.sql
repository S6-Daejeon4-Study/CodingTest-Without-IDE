select s.hacker_id, h.name from submissions s
inner join challenges c on s.challenge_id = c.challenge_id
inner join difficulty d on d.difficulty_level = c.difficulty_level
inner join hackers h on h.hacker_id = s.hacker_id
where s.score = d.score and  d.difficulty_level = c.difficulty_level
group by s.hacker_id, h.name
having count(*) > 1
order by count(*) desc, s.hacker_id;