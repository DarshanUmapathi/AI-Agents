# Payments

Payment retries may cause duplicate charges if idempotency keys

are not used. Always include an idempotency key when retrying

payment requests.