 ## CAP theorem     

In a distributed computer system, only support two of the following guarantees:

* Consistency - Every read receives the most recent write or an error
* Availability - Every request receives a response, without guarantee that it contains the most recent version of the information
* Partition Tolerance - The system continues to operate despite arbitrary partitioning due to network failures

Because networks are not always reliable, it is necessary for systems to support partition tolerance. This means that in software design, there must be a trade-off between consistency and availability.  

* CP - consistency and partition tolerance
Waiting for a response from the partitioned node might result in a timeout error.  

    ###### CP is a good choice if the business needs require atomic reads and writes.

* AP - availability and partition tolerance
Responses return the most readily available version of the data available on any node, which might not be the latest. Writes might take some time to propagate when the partition is resolved.

    ###### AP is a good choice if the business needs to allow for eventual consistency or when the system needs to continue  working despite external errors.
