package constuction.project.data.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import constuction.project.data.Repository.ContractorRepository;
import constuction.project.data.Repository.ProductRepository;
import constuction.project.data.beans.Project;
import constuction.project.data.beans.contractor;
import constuction.project.data.exception.ResourceNotFoundException;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/services/")
public class ProductController {

	@Autowired
	private ProductRepository productService;
	@Autowired
	private ContractorRepository contractorRepository;

	@PostMapping("/projects")
	public ResponseEntity<?> createproject(
		@RequestPart("file") MultipartFile file,
			@RequestParam("category") String category, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") double price,
			@RequestParam("contractorId") Long contractorId) {
		try {

			Project project = new Project();
			project.setCategory(category);
			project.setName(name);
			project.setDescription(description);
			project.setPrice(price);

			System.out.println(project);
			contractor contractor = contractorRepository.findById(contractorId)
					.orElseThrow(() -> new ResourceNotFoundException("Contractor not found"));

			contractor.setProject(project);
			// Save image file and set image path
			if (!file.isEmpty()) {
			// Save the file to the specified directory
			String uploadDir = "E:/img/";
			String imagePath = "E:/img/" + file.getOriginalFilename();
			File uploadedFile = new File(uploadDir + file.getOriginalFilename());
			FileOutputStream outputStream = new FileOutputStream(uploadedFile);
			outputStream.write(file.getBytes());
			outputStream.close();
			// Set image path in the project
			project.setImagePath(imagePath);
			}

			// Save the project
			contractorRepository.save(contractor);

			return new ResponseEntity<>("project created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to create project: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
//    @GetMapping("/products/{contractorId}")
//    public ResponseEntity<List<Project>> getProductsByContractorId(@PathVariable Long contractorId) {
//    	System.out.println("id :"+contractorId);
//        List<Project> products = productService.findByContractorId(contractorId);
//        if (products.isEmpty()) {
//            throw new ResourceNotFoundException("No products found for contractor with id: " + contractorId);
//        }
//        return ResponseEntity.ok(products);
//    }
			    
}