select w2.Id
from Weather w1 join Weather w2
on TO_DAYS(w1.RecordDate) + 1 = TO_DAYS(w2.RecordDate)
and w1.Temperature < w2.Temperature

SELECT a.Id FROM Weather AS a, Weather AS b
WHERE DATEDIFF(a.Date, b.Date)=1 AND a.Temperature > b.Temperature
