local stock = redis.call("get", KEYS[1]);
local count = ARGV[1];
local str = stock .. count;
return str;
--stock = tonumber(stock);
--local buyCount = tonumber(ARGV[1]);
--if(stock < buyCount)
--then
--    return 'fail';
--else
--    stock = stock - buyCount;
--    redis.call("hset" , KEYS[1] , "stock" , tostring(stock));
--    return 'success';
--end