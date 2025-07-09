# 📧 Send Email with Azure Graph API using OAuth 2.0 in Spring Boot

This project demonstrates how to send emails using **Microsoft Graph API** with **modern OAuth 2.0 authentication** in a **Spring Boot** application. This is the recommended approach since **Basic Authentication is deprecated** for Office365/Exchange Online.

---

## 🔐 Why Use OAuth 2.0 with Microsoft Graph?

Microsoft has officially deprecated Basic Auth for SMTP and recommends using Microsoft Graph API with OAuth 2.0 for secure and modern access to services like email, calendar, and contacts.

---

## ⚙️ Technologies Used

- Spring Boot
- Microsoft Graph SDK (Java)
- Azure Identity SDK
- OAuth 2.0 (Client Credentials Flow)
- REST API

---

## 📥 Prerequisites

Before running this project, you must:

1. Register an application in **Azure Portal**
2. Add the following **application permissions** under Microsoft Graph:
   - `Mail.Send`
   - (Optionally) `User.Read.All`
3. Click **"Grant admin consent"** for the permissions
4. Generate a **Client Secret** for your app

---

## 🔑 Required Configuration

Add these to your `application.yml` or as environment variables:

```yaml
azure:
  client-id: <your-client-id>
  client-secret: <your-client-secret>
  tenant-id: <your-tenant-id>
