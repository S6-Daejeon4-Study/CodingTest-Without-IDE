SELECT round(sqrt(pow(abs(max(lat_n)- min(lat_n)),2)+pow(abs(max(long_w)-min(long_w)),2)),4)
FROM STATION;