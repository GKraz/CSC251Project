import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Project_giovanni_krasner
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("PolicyInformation.txt");

        if (!file.exists()) {
            System.out.println("Could not find file!");
            return;
        }

        Scanner inputFile = new Scanner(file);

        StringBuilder serializedPolicies = new StringBuilder();

        while(inputFile.hasNext()) {
            serializedPolicies.append(inputFile.nextLine()).append("_");
        }

        String[] serializedPoliciesArray = serializedPolicies.toString().split("__");
        Policy[] policiesArray = new Policy[serializedPoliciesArray.length];

        for (int i = 0; i < serializedPoliciesArray.length; i++) {
            String serializedPolicyData = serializedPoliciesArray[i];
            String[] parsedPolicyData = serializedPolicyData.split("_");

            Policy policy = new Policy();
            policy.SetPolicyNumber(Integer.parseInt(parsedPolicyData[0]));
            policy.SetProviderName(parsedPolicyData[1]);
            policy.SetHolder(new PolicyHolder(
                    parsedPolicyData[2], // First Name
                    parsedPolicyData[3], // Last Name
                    parsedPolicyData[5], // Smoking status
                    Integer.parseInt(parsedPolicyData[4]), // Age
                    Double.parseDouble(parsedPolicyData[6]), // Weight
                    Double.parseDouble(parsedPolicyData[7]))); // Height

            policiesArray[i] = policy;
        }

        for(Policy policy : policiesArray) {
            System.out.println(policy);
        }

        System.out.printf("\nThere were %d Policy objects created.\n", Policy.policyCount);
        System.out.printf("\nThe number of policies with a smoker is: %d", Policy.smokerCount);
        System.out.printf("\nThe number of policies with a non-smoker is: %d", serializedPoliciesArray.length - Policy.smokerCount);
    }
}
