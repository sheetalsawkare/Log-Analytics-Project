# Log-Analytics-Project
I built a real-time log analytics service using sliding window technique. The system ingests logs and maintains only last 60 seconds using a deque. I implemented metrics like total logs, error count and error rate. The service supports real-time monitoring and spike detection. Thread safety was handled using synchronized methods.
