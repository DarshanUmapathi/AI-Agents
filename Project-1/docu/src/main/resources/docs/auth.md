# Authentication


Access tokens expire after 60 minutes for security reasons.

Clients must refresh the token using the refresh token flow.

Expired tokens will result in HTTP 401 responses.