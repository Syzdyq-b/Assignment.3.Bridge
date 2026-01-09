public class main {
    public static void main(String[] args) {

        JobListingDB.createTable();

        JobListingDB.addJob(
                "Java Developer",
                "Backend developer needed",
                5000
        );



                JobListingDB.createTable();
                FreelancerDB.createTable();
                PortalDB.createTable();

                JobListingDB.addJob("Backend Dev", "Java + PostgreSQL", 4000);
                FreelancerDB.addFreelancer("Ali", "Java", 25);
                PortalDB.addPortal("FreelanceHub", "Platform for freelancers");

                JobListingDB.getAllJobs();
                FreelancerDB.getAllFreelancers();
                PortalDB.getAllPortals();

    }
}
