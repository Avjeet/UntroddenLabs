# UntroddenLabs

## 3rd Party Libraries Used
- Retrofit2
- Realm Database
- MSG91

## Additional Information

#### First Screen - First Tab

- Firstly created JSON file (in assets folder) with contact data containing four fields : "Name", " Number" , "Address", "Gender"

- Then Parsed that JSON file using FileReader class and stored each entry into Realm Database.

#### Second screen 

- The record related to every contact is being fetched from Realm database and inflated on the layout.
 
- Otp is generated using Random function

#### Third Screen

- For sending OTP MSG91 service is used.

- For accessing MSG91 api I have created POST request using retrofit2 library which requires five query parameters : "auth_key", "sender", "message", "mobile", "otp"

#### First Screen-Second Tab

- For every successful request the time and contact in stored in Realm Database History Model which is shown in tab 2 of first screen.
