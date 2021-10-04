-- JOIN QUERY TO GET ORDER ITEMS.
SELECT i.item_id,i.item_name, i.description, ot.order_id
FROM order_items o
         INNER JOIN orders ot  ON ot.order_id = o.order_id
         INNER JOIN item i on o.item_id = i.item_id
WHERE ot.order_id = '1'