--
-- Created by IntelliJ IDEA.
-- User: DELL
-- Date: 2019/3/11
-- Time: 16:47
-- To change this template use File | Settings | File Templates.
--
local stock = redis.call("hget", KEYS[1], "stock");
stock = tonumber(stock);
local buyCount = tonumber(ARGV[1]);
if (stock < buyCount) then
    return 'fail';
else
    stock = stock - buyCount;
    redis.call("hset", KEYS[1], "stock", tostring(stock));
    return 'success';
end