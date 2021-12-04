

## test of app:

1. Run application 
2. Use postman or curl to run scenarios 
3. to add/update transaction
```
curl -X POST -H "Content-Type: application/json" -d '{"id": 10000, "price": 1000, "customerId": "1"}'  localhost:8080/api/transactions/add
```
4. to get reward points for one month
```
curl GET localhost:8080/api/reward-program/1/month-score
```
5. to get reward points total
```
curl GET localhost:8080/api/reward-program/1/total-score
```
6. to get error handling 
```
curl GET localhost:8080/api/reward-program/11/month-score
```