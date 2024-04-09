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
        int smokerCount = 0;

        for (int i = 0; i < serializedPoliciesArray.length; i++) {
            String serializedPolicyData = serializedPoliciesArray[i];
            String[] parsedPolicyData = serializedPolicyData.split("_");

            Policy policy = new Policy();
            policy.SetPolicyNumber(Integer.parseInt(parsedPolicyData[0]));
            policy.SetProviderName(parsedPolicyData[1]);
            policy.SetHolderFirstName(parsedPolicyData[2]);
            policy.SetHolderLastName(parsedPolicyData[3]);
            policy.SetHolderAge(Integer.parseInt(parsedPolicyData[4]));
            policy.SetSmokingStatus(parsedPolicyData[5]);
            policy.SetHolderHeight(Double.parseDouble(parsedPolicyData[6]));
            policy.SetHolderWeight(Double.parseDouble(parsedPolicyData[7]));

            if (policy.GetSmokingStatus().equalsIgnoreCase("smoker")) smokerCount += 1;

            policiesArray[i] = policy;
        }

        for(Policy policy : policiesArray) {
            System.out.println(policy);
        }

        System.out.printf("\nThe number of policies with a smoker is: %d", smokerCount);
        System.out.printf("\nThe number of policies with a non-smoker is: %d", serializedPoliciesArray.length - smokerCount);
    }
}
