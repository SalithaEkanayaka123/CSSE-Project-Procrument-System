-- JOIN QUERY TO GET ORDER ITEMS.
SELECT i.item_id,i.item_name, i.description, ot.order_id
FROM order_items o
         INNER JOIN orders ot  ON ot.order_id = o.order_id
         INNER JOIN item i on o.item_id = i.item_id
WHERE ot.order_id = '1'


-- JOIN QUERY TO GET DELIVERY ITEMS.
SELECT i.item_name, i.description, i.price, d.orderid, d.deliveryid
FROM item_delivery_advice a
         INNER JOIN item i  ON i.item_id = a.item_id
         INNER JOIN deliveryadvice d ON d.deliveryid = a.delivery_advice_id
WHERE d.orderid = '2'