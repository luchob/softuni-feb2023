package bg.softuni.blacklist.service;

import org.springframework.stereotype.Service;

@Service
public class BlackListService {

  public boolean isBlacklisted(String ipAddress) {
    // TODO: Please be more realistic :-)
    // e.g. create repository where the admin may manage blacklisted IP-s
    return false;
  }

}
