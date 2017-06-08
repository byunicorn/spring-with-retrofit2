package com.springapp.mvc;

import com.springapp.service.GitHubService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
    private GitHubService gitHubService;

    @Required
    public void setGitHubService(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        Call<List<String>> call = gitHubService.listRepos("byunicorn");
        try {
            Response<List<String>> response = call.execute();
            List<String> rep = response.body();
            System.out.print(rep);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
	}
}