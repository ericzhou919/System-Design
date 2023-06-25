# Design Youtube system

### Step 1-Ask the interviewer and confirm the requirements  

Candidate: What features are important?  
Interviewer: Ability to upload a video and watch a video.  

Candidate: What clients do we need to support?  
Interviewer: Mobile apps, web browsers, and smart TV.  

Candidate: How many daily active users do we have?  
Interviewer: 5 million  

Candidate: What is the average daily time spent on the product?  
Interviewer: 30 minutes.  

Candidate: Do we need to support international users?  
Interviewer: Yes, a large percentage of users are international users.  

Candidate: What are the supported video resolutions?  
Interviewer: The system accepts most of the video resolutions and formats.  

Candidate: Is encryption required?  
Interviewer: Yes  

Candidate: Any file size requirement for videos?  
Interviewer: Our platform focuses on small and medium-sized videos. The maximum allowed video size is 1GB.  

Candidate: Can we leverage some of the existing cloud infrastructures provided by Amazon, Google, or Microsoft?  
Interviewer:Yes.    

Now, we focus on designing a video streaming service with the following features:
- Ability to upload videos fast
- Smooth video streaming
- Ability to change video quality
- Low infrastructure cost
- High availability, scalability, and reliability requirements
- Clients supported: mobile apps, web browser, and smart TV



### Step 2-Capacity estimation and System Constraints

Assuming we have：

- Total of 2 billion users.
- Daily active users of 400 million.
- A user watches 5 videos a day.
- A total of 5 multiplied by 400 million, 2 billion views per day.

### Step 3-High-Level Design
![image](https://github.com/ericzhou919/System-Design/assets/77151742/f00b7efd-3bd8-4ad9-a3dc-37115b9678d7)
