# Design Youtube system

### Step 1-Ask the interviewer and confirm the requirements  

Functional requirements：

- Users should be able to upload videos.
- Users should be able to view videos.
- Users should be able to change video quality.
- The system should also keep the count of likes, dislikes, comments and views to present these numbers to users.

Non-Functional requirements：

- Video uploading should be fast, and users should have a smooth streaming experience.
- The system should be highly available, scalable, and reliable. We can compromise with consistency to offer high availability.
- The system should offer low latency and high throughput.
- The system should be cost-efficient.

### Step 2-Capacity estimation and System Constraints

Assuming we have：

- Total of 2 billion users.
- Daily active users of 400 million.
- A user watches 5 videos a day.
- A total of 5 multiplied by 400 million, 2 billion views per day.

### Step 3-High-Level Design
![image](https://github.com/ericzhou919/System-Design/assets/77151742/f00b7efd-3bd8-4ad9-a3dc-37115b9678d7)
